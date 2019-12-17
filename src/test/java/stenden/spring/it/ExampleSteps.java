/*
 * Copyright 2006-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package stenden.spring.it;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.dsl.runner.TestRunner;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;

/**
 * designer
 *
 * @author Christoph Deppisch
 */
public class ExampleSteps {

    /**
     * Test runner filled with actions by step definitions
     */
    @CitrusResource
    private TestRunner runner;

    @When("^The client makes a GET request to  \"([^\"]*)\"$")
    public void callUrl(String url) {
        runner.http(httpActionBuilder -> httpActionBuilder
                .client("springAppClient")
                .send()
                .get(url));
    }

    @Then("^The HTTP status code should be (\\d+)$")
    public void expectedHttpStatus(int status) {
        runner.http(httpActionBuilder -> httpActionBuilder
                .client("springAppClient")
                .receive()
                .response(HttpStatus.valueOf(status)));
    }

//    @Given("^Todo list is empty$")
//    public void empty_todos() {
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .send()
//            .delete("/api/todolist"));
//
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .receive()
//            .response(HttpStatus.OK));
//    }
//
//    @When("^(?:I|user) adds? entry \"([^\"]*)\"$")
//    public void add_entry(String todoName) {
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .send()
//            .post("/todolist")
//            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//            .payload("title=" + todoName));
//
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .receive()
//            .response(HttpStatus.FOUND));
//    }
//
//    @When("^(?:I|user) removes? entry \"([^\"]*)\"$")
//    public void remove_entry(String todoName) throws UnsupportedEncodingException{
//        String encoding = URLEncoder.encode(todoName, "UTF-8");
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .send()
//            .delete("/api/todo?title=" + encoding));
//
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .receive()
//            .response(HttpStatus.OK)
//            .messageType(MessageType.PLAINTEXT));
//    }
//
//    @Then("^(?:the )?number of todo entries should be (\\d+)$")
//    public void verify_todos(int todoCnt) {
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .send()
//            .get("/api/todolist/count"));
//
//        runner.http(httpActionBuilder -> httpActionBuilder
//            .client("todoListClient")
//            .receive()
//            .response(HttpStatus.OK)
//            .messageType(MessageType.PLAINTEXT)
//            .payload(String.valueOf(todoCnt)));
//    }
//
//    @Then("^(?:the )?todo list should be empty$")
//    public void verify_empty_todos() {
//        verify_todos(0);
//    }

}
