package org.acme.spring.web;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/helloworld")
@OpenAPIDefinition(
        info = @Info(
                title="HelloWorld API",
                version = "1.0.1",
                contact = @Contact(
                        name = "HelloWorld API Support",
                        url = "http://exampleurl.com/contact",
                        email = "ovuncsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class HelloWorldController {
    @Tag(name = "Hello", description = "Just say hello to world")
    @GetMapping(produces= MediaType.TEXT_PLAIN_VALUE)
    public String helloWorld() {
        return "Ovunc says hello world!";
    }

    @GetMapping(value = "/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Hello by name", description = "Say hello to given name")
    public Hello sayHello(@PathVariable(name = "name") String name) {
        return new Hello("hello " + name);
    }

    public static class Hello {
        private final String message;

        public Hello(String message) {
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }
}
