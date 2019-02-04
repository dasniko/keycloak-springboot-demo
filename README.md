# Keycloak Spring Boot Demo

Demo for Spring Boot and Keycloak SSO integration.

## Running Keycloak locally
1. [Download and install Keycloak.](http://www.keycloak.org/downloads.html)

1. [Complete the initial setup documentation and create your admin user, etc.](https://keycloak.gitbooks.io/documentation/getting_started/index.html)

You should now find Keycloak running at [http://localhost:8080](http://localhost:8080).

## Configuring Keycloak
As shown in the `application.properties` sample included in this project, you'll need to create the following in your Keycloak instance:

### Realm
1. Create realm: `demo`
1. Create `user` role in realm. (Not a "client" role.)

### Client
1. Create `crm` client.
1. Set "Valid Redirect URIs:" `http://localhost:9000/*`

### Role
You'll probably want to create a new demo user instead of your newly-created KC admin account.
1. Create demo user (choose a convenient name). Set password and select/de-select "Temporary" as desired.
1. Assign `user` role to the demo user in User's "Role mappings" page.

## Running the demo app from the CLI
1. Clone/download source
1. `mvn clean install`
1. `mvn spring-boot:run`

You should now find the demo running at [http://localhost:9000](http://localhost:9000) (You can change this port in the `application.properties` file as needed.)