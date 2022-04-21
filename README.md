# project_catalog_api

Api which manages products and categories

	Product catalog api written in java, using the spring boot framework.
	The repository has two branches:
[master branch](https://github.com/achilep/project_catalog_api): The basic version of the api, in which products have no images 
	representing them
[project_catalog_api_with_image branch](https://github.com/achilep/project_catalog_api/tree/project_catalog_api_with_image): The version of the api in which products 
	have images
	
## Getting started
1.  Have spring tool suite(STS) ide or sts integrated into a java ide of your choice
2.	Optionally have access to internet connection so as to download any dependencies on-the-go if needed.

## Running the api

1.	Clone the repository
2.  Import the project from the clone repository into an IDE equiped with STS.
3.	The application can then be run (as a spring boot app).

	
	It runs on the default port (8080), that is localhost:8080 is the root
	
#### Alternatively, the api can be tested online by accessing either of these links:

[HOSTED API without images](https://sheltered-falls-45349.herokuapp.com/swagger-ui.html)

[HOSTED API with image in product](https://shielded-crag-51074.herokuapp.com/swagger-ui.html)

## Understanding the api

	
The application has two controllers (each with several endpoints). 
A detailed overview of each enpoint can be seen in the swagger documentation: 
While the application is running in the IDE, Visit the resource below from a web browser:

	localhost:8080/swagger-ui.html

