# project-Repo

For all things soen 342 project

SOEN 342 - SECTION H

- Kadir Altinay
  - 40166610
  - kadiraltny2@gmail.com
- Dominique Proulx
  - 40177566
  - dominique.proulx@mail.concordia.ca

### Project Discussion : https://github.com/Kadir-Dominique-SOEN342/project-Repo/discussions/1
---
## SRS : 

### Use case diagrams 
[high level of abstraction](SRS\UseCase_v4.jpg)
- [signUp/Signin](SRS\UseCase_Diagram_SignUpSignIn_v1.jpg)
- [process Offerring](SRS\UseCase_Diagram_ProcessOfferings_v1.jpg)
- [Process Booking](SRS\UseCase_Diagram_ProcessBookings_v1.jpg)



### UML domain model and package diagram
-  [UML Domain model](SRS/UmlDomainModel_v11.jpg)
-   Uml package Diagram : It was decided to keep everything in the same package.

## System Sequence Diagrams 
- For critical use case Signup to lesson
  - [Signup to lesson Success] (SRS\SystemSequenceDiagram_SignupToLesson.jpg)
  - [Signup to lesson failures] (SRS\SystemSequenceDiagram_SignupToLesson_Failures.jpg)
- For critical use case create Booking:
  - [create booking success] ()
  - [create booking failure] () 
others 
-
- 


## System operations

- Critical use case signup To lesson :

    viewOffering()
    signupToLesson()

- Critical use case create Booking :

    viewOffering()
    makeBooking()
    underageBooking()
    createBooking()


## System operation contracts 
- For critical use case [Signup to lesson] (SRS\System_Operations_Contracts_signupToLesson)
- For critical use case [create Booking]

others 
-
- 


---
SAD 
UML Class Diagram
OCL

## Interaction diagrams
 For critical use case Signup to lesson : 
For critical use case create Booking: 

other s 
-
- 


--- 
PERSISTANCE
 ## relational models
 -
----



---


## Interation 1

### SRS

- [Use Case Diagram](SRS/UML_UseCase_v3.jpg)

## Interation 2

### SRS

- [UML Domain model](SRS/UmlDomainModel_v11.jpg)
- [UML package Diagram]

#### System Sequence Diagram

- [Process Offering System Sequence diagram](SRS/SystemSequenceDiagram- ProcessOffering_v2.jpg)
- [Process Offering System operations](SRS/ProcessOffering_System_Operation_)

#### Process oferring system operations contract

- [Operation contract for System Operations of Process Offerings](SRS/System_Operations_Contracts_ProcessOfferings)

### SAD

#### UML Interaction diagrams

- [uploadOffering()](SAD/UploadOffering_v7.jpg)
- [deleteOffering()](SAD/InteractionDiagram_deleteOffering_v2.jpg)
- [viewOffering()](SAD/InteractionDiagrams/InteractionDiagram_viewOffering_v4.jpg)
- [ signuptoLesson()](SAD/InteractionDiagrams/InteractionDiagram_signupToLesson_v4.jpg)

#### UML Class diagram

- [UML Class Diagram](SAD/UmlClassDiagram_v9.jpg)

### Implementation

- [link to Java project](lessonator2000)

## Iteration 3

### SRS

#### System Sequence Diagram

- [Process Booking System Sequence diagram]()
- [Process Booking System operations]()

#### Process Booking system operations contract

- [Operation contract for System Operations of Process Booking](SRS/System_Operations_Contracts_ProcessBooking)

### SAD

#### UML Interaction diagrams

- [makeBooking()](SAD/InteractionDiagram_makeBooking_v5.jpg)
- [cancelBooking()](SAD/InteractionDiagram_CancelBooking_v2.jpg)
- [viewBooking()](SAD/InteractionDiagram_ViewBooking_v2.jpg)
