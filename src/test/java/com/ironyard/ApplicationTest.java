/*
 * Copyright 2012-2015 the original author or authors.
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

package com.ironyard;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.ironyard.data.*;
import com.ironyard.repositories.*;
import com.sun.xml.internal.ws.api.server.DocumentAddressResolver;
import javafx.scene.input.DataFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sun.jvm.hotspot.utilities.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "logging.level.org.springframework.web=DEBUG")
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    BootCampRepo bootCampRepo;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    AddressRepo addressRepo;

    @Test
    public void rendersForm() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Form")));
    }

    @Test
    public void submitsForm() throws Exception {
        mockMvc.perform(post("/greeting").param("id", "12345").param("content", "Hello"))
                .andExpect(content().string(containsString("Result")))
                .andExpect(content().string(containsString("id: 12345")));
    }

    @Test
    public void testRelations() throws Exception{
        Company company1 = new Company("Aptech");
        BootCamp bootCamp1 = new BootCamp("IronYard", "1-mar-2017","31-mar-2017");
        Instructor instructor1 = new Instructor("Jason", "21-Sep-2016");
        Student std1 = new Student("Osman","canohibro@gmail.com");
        Student std2 = new Student("Wail","wail.yousif@gmail.com");
        Address address1 = new Address("Pine","Orlando","Florida","DownTown");
        Address address2 = new Address("orange","Orlando","Florida","Mateland");

        std1.setHomeAddress(address2);
        std2.setHomeAddress(address2);
        List<Student> studentList = new ArrayList<>();
        studentList.add(std1);
        studentList.add(std2);
        bootCamp1.setStudents(studentList);

        instructor1.setHomeAddress(address2);
        instructor1.setWorkAddress(address1);
        instructor1.setBootCampTaught(bootCamp1);


        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(instructor1);

        company1.setTeachers(instructorList);
        companyRepo.save(company1);

        org.junit.Assert.assertNotNull(company1);

    }

}
