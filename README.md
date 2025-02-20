# project-Repo

For all things soen 342 project

SOEN 342 - SECTION H

- Kadir Altinay
  - 40166610
  - kadiraltny2@gmail.com
- Dominique Proulx
  - 40177566
  - dominique.proulx@mail.concordia.ca

## Presentation video [video](https://1drv.ms/v/s!ApEs5uhugF8kkLZQ9jppOeIYz_mnAw?e=2fAQSC)

## Implementation


***The implementation of the persistance was done and kept on a separate branch. 
We have chose hibernate as the framework to help with implementating persistance. 
Unfortunately we faced challenges since the system wasn't originally designed with Hibernate in mind. Implementing persistence across the entire system turned out to be more complex than expected, as it became clear that it was more of an "all-or-nothing" situation. 
To avoid impacting the integrity of the working system, we decided to keep the persistence implementation on a separate branch. This allows us to demonstrate how persistence was integrated for the critical use cases.***
- [link to Java project](lessonator2000)
- [link to the Pesistance branch " stillPersistence"]([stillPersistence](https://github.com/Kadir-Dominique-SOEN342/project-Repo/tree/stillPersistence)) 

### Project presentation 
### Project Discussion : https://github.com/Kadir-Dominique-SOEN342/project-Repo/discussions/1

---

## SRS :

### Use case diagrams

[high level of abstraction](SRS/UseCase_v4.jpg)

- [signUp/Signin](SRS/UseCase_Diagram_SignUpSignIn_v1.jpg)
- [process Offerring](SRS/UseCase_Diagram_ProcessOfferings_v1.jpg)
- [Process Booking](SRS/UseCase_Diagram_ProcessBookings_v1.jpg)

### UML domain model and package diagram

- [UML Domain model](SRS/UmlDomainModel_v11.jpg)
- Uml package Diagram : It was decided to keep everything in the same package.

### System Sequence Diagrams

#### For critical use case Signup to lesson

- [Signup to lesson Success](SRS/SystemSequenceDiagram_SignupToLesson.jpg)
- [Signup to lesson failures](SRS/SystemSequenceDiagram_SignupToLesson_Failures_v3.jpg)
#### For critical use case create Booking:
- [create booking success](SRS/SystemSequenceDiagram_makeBooking.jpg)
- [create booking failure](SRS/SystemSequenceDiagram_makeBooking_Failures.jpg)

### System operations

- Critical use case signup To lesson :

  - viewOffering()
  - signupToLesson()

- Critical use case create Booking :

  - makeBooking()
  - underageBooking()
  - createBooking()
  - viewBooking()

### System operation contracts

- For critical use case [Signup to lesson](SRS/System_Operations_Contracts_signupToLesson)
- For critical use case [create Booking](SRS/System_Operations_Contracts_makeBooking)

others

- [System operations contracts for non critical use case of Process Offering](SRS/SystemOperation_Contracts_ProcessOfferings_NonCritical)
- [System operations contracts for non critical use case of Process Booking](SRS/SystemOperation_Contracts_processBooking_NonCritital)

---

## SAD

### UML Class diagram and attached OCL

- [UML Class Diagram](SAD/UmlClassDiagram_v15.jpg)
- [OCL](SAD/UMLClassDiagram_OCL.ocl)

### Interaction diagrams

For critical use case Signup to lesson :

- [Interaction Diagram for viewOffering()](SAD/InteractionDiagram_viewOffering_v5.jpg)
- [Interaction Diagram for signupToLesson()](SAD/InteractionDiagram_signupToLesson_v6.jpg)

For critical use case create Booking:

- [interaction Diagram for makeBooking()](SAD/InteractionDiagram_makeBooking_v6.jpg)
- [interaction Diagram for underageBooking()](SAD/InteractionDiagram_underageBooking_v2.jpg)
- [interaction Diagram for createBooking()](SAD/InteractionDiagram_createBooking.jpg)
- [interaction Diagram for viewBooking()](SAD/InteractionDiagram_ViewBooking_v2.jpg)

Interaction diagram for non critical use cases:

- [interaction Diagram for uploadOffering()](SAD/InteractionDiagram_UploadOffering_v8.jpg)
- [interaction Diagram for deleteOffering()](SAD/InteractionDiagram_deleteOffering_v2.jpg)
- [interaction Diagram for cancelBooking()](SAD/InteractionDiagram_CancelBooking_v2.jpg)

---

PERSISTANCE

## relational models

- [Relational Model](SAD/RelationalModel.png)
