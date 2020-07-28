package com.xr.nettychat.thrifts.service;

import com.xr.nettychat.thrifts.generated.DataException;
import com.xr.nettychat.thrifts.generated.Person;
import com.xr.nettychat.thrifts.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUserName(String username) throws DataException, TException {
        System.out.println("get client request: " + username);
        Person person = new Person();
        person.setUesrname("kevin");
        person.setAge(12);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("get client request for saving: ");
        System.out.println(person.getUesrname());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
