## Setup in IntelliJ IDEA for Development

Clone the repo. Make sure to "Open" the project, instead of "Import Project"
If the classes and methods specific to Appian don't load in the EnableDeploymentApiAppImport module, manually import external libraries by navigating to Project Structure -> Libraries -> (+) symbol at the top -> selecting Java project library -> selecting the folder EnableDeploymentApiAppImport/build-tools

## Rebuild the jar file

First, you need to check the Project Structure -> Modules -> Dependencies, and see if the appian-plugin-sdk.jar is there. If not, add it via the path EnableDeploymentApiAppImport/build-tools/appian-plugin-sdk.jar

Create an artifact configuration for the JAR.

From the main menu, select “File | Project Structure”, and click “Artifacts”.
Click the “+” button, point to JAR and select “From modules with dependencies”.
For the “Main Class” field, enter in `com.appiancorp.plugin.enabledeploymentapi.EnableDeploymentApiAppImportActivator`.
Click the “Ok” button.
Within the “Project Structure Artifacts” window under the “Output Layout” tab click the “+” button to add the “appian-plugin.xml” file, if it is there.

The Appian SDK file is not needed for deploying the Plugin.  Note other libraries that are included with Appian code will need to be excluded also.  For example JAVAX.

Within the “Project Structure Artifacts” window under the “Output Layout” tab select the “-” button to remove the “appian-plug-in-sdk.jar”.

Building the JAR file

Within IntelliJ select “Build Artifacts” from the “Build” menu.
Select “Build” from the context menu.
Observe the “out” directory that was created.  This directory contains the EnableDeploymentApiAppImport.jar” file.

## Deploy the JAR file

Within the Appian application directory place the JAR file in “/_admin/plugins/”.
Login into the Appian application and navigate to the Admin Plugin section.  You should see the plugin is deployed.
