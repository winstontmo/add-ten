/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@SpringBootApplication
public class Main {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @GetMapping("/test")
  String test() {
    return "abc";
  }

  @RequestMapping(value = "/test/{v1}", method = RequestMethod.GET, produces = { "application/json" })
  String test1(int v1) {
    JSONObject jo = new JSONObject();

    HashMap<String, Integer> ans = new HashMap<>();
    ans.put("sum", v1 + 10);
    return jo.toString();
  }

  @RequestMapping(value = "/add/{v1}", method = RequestMethod.GET, produces = { "application/json" })
  ResponseEntity<HashMap<String, Integer>> add(@PathVariable("v1") int v1) {
    HashMap<String, Integer> ans = new HashMap<>();
    ans.put("sum", v1 + 10);
    return new ResponseEntity<HashMap<String, Integer>>(ans, HttpStatus.OK);
  }

}
