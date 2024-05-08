package test;

import session06.proxy.Man;
import session06.proxy.Person;
import session06.proxy.PersonProxy;
import session06.proxy.Woman;

public class TestPerson {
	public static void main(String[] args) {
		Person man = new PersonProxy(new Man());
		man.work();
		
		Person woman = new PersonProxy(new Woman());
		woman.work();
	}
}
