#include <iostream>
using std::string;

// Interface/abrtact class of employee
class IEmployee {
  // making it virtual = 0 
  // Makes the class abstarct -> WHo ever signs the contreact needs to implemt it
  virtual void AskForPromotion()=0;
};

class Employee:IEmployee {
protected:
  // Attributes of the class
  string Name;
  string Company;
  int Age;

public:
  void setName(string name) {
    Name= name;
  }
  string getName() {
    return Name;
  }
  void setCompany(string company) {
    Company= company;
  }
  string getCompany() {
    return Company;
  }
  void setAge(int age) {
    if(age >= 18) {
      Age = age;
    }
  }
  int getAge() {
    return Age;
  }
  
  
  // Constructor
  Employee(string name, string company, int age) {
    Name = name;
    Company = company;
    Age = age;
  }

  // Can desrcibe behaviouirs as well
  // By creatign class methods or fucntions
  void Introduce(){
    std::cout << "Name - " << Name << std::endl;
    std::cout << "Company- " << Company << std::endl;
    std::cout << "Age - " << Age << std::endl;
  }
  void AskForPromotion() {
    // for now lets say eveyone over 30 can ask for promotion
    if (Age > 30) std::cout << Name << " got promoted" << std::endl;
    else std::cout << Name << ", sorry no promotion for you" << std::endl;
  }
  virtual void Work() {
    std::cout << Name << " is checking email, task backlog, performing tasks..." << std::endl;
  }
};

// Developer became a child class of Employee
// i.e. Inheritence
// is private by default need to add public so that Developer instance can uise Employee methods
class Developer:public Employee {
private:
  string FavProgLang;



public:
  string getFavProgLang() {
    return FavProgLang;
  }

  void FixBug() {
    std::cout << Name << " fixed bug using " << FavProgLang << std::endl;
  }
  
  Developer(string name, string company, int age, string favProgLang) 
    // Employee knows how to construct everything that employee had
    :Employee(name, company, age) {
    
    FavProgLang = favProgLang;

  }
};

class Teacher:public Employee {
  string Subject;

public:
  void PrepareLesson() {
    std::cout << Name << " is preperiong " << Subject << " lesson " << std::endl;
  }

  Teacher(string name, string company, int age, string subject) 
    // Employee knows how to construct everything that employee had
    :Employee(name, company, age) {
    Subject = subject;

  }
  void Work() {
    std::cout << Name << " is teahcing " << Subject << std::endl;
  }
};

int main () {
  // Create an instance of the class
  // Employee employee1 = Employee("Aryan", "MSFT", 23);
  // Employee employee2 = Employee("Bob", "Citadel", 23);

  Developer d = Developer("Chris", "Citadel", 21, "C++");
  // d.FixBug();
  // d.AskForPromotion();
  Teacher t = Teacher("David", "MFHS", 54, "Maths");
  // t.PrepareLesson();
  // t.AskForPromotion();
  // d.Work();
  // t.Work();

  // Polymorphsim When a parent class refewrence is used to refer to a child class object
  // needs to make trhe work function virtual
  // employee pointer which holds a reference to a developer
  Employee *e1 = &d;
  Employee *e2 = &t;

  e1->Work();
  e2->Work();

  // employee2.setCompany("IMC");
  // employee2.setAge(12);
  // employee1.setAge(32);

  // employee1.Introduce();
  // employee2.Introduce();
  // employee1.AskForPromotion();
  // employee2.AskForPromotion();

  
}

// Encapsulation - Packaging data together
// Tieing data together with methdoss that oeprate on that datat within a class
// we do this that only our class can access and modifiy our data
// we can cretae public fucntions for other function/classes to invokle this class
// Getters and setters
// make attributes prviate

// Abstraction - Hiding complex functionality
// Hiding complex things behind a procedure that makes it look simple
// Functions are black boxes 
// Creating an interface to abstract away complexity (we dont need to know about this)
// Users need to sign a contract to show you the interface without showing the complex side
// Use abstract class to simulate a interface (from Java)

// Inheritence
// There is a super class (parent class) -> has members (attributes and behaviours)
// a child class can inherit these memebrs from the super class -> that is it will have the
// same atrributes and behaviours
// But can have its own members (its own unique methods and attributes)

// Polymorphism - many forms - ability opf an object to have many forms
// Same method can have different implementations depending on which child class is invoking it
// When a parent class refewrence is used to refer to a child class object