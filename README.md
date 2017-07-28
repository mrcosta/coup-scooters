# coup-scooters

[![Build Status](https://travis-ci.org/mrcosta/coup-scooters.svg?branch=master)](https://travis-ci.org/mrcosta/coup-scooters)
[![codecov](https://codecov.io/gh/mrcosta/coup-scooters/branch/master/graph/badge.svg)](https://codecov.io/gh/mrcosta/coup-scooters)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/24e4d7122751476382e7d13a557cfea4)](https://www.codacy.com/app/mrcosta/coup-scooters?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mrcosta/coup-scooters&amp;utm_campaign=Badge_Grade)

# How to run

It was creates a rest API. Then to start the application:

```bash
./gradlew bootRun
```

And an example of request:

```bash
curl -H "Content-Type: application/json" -X POST -d '{"scooters": [15, 10], "C": 9, "P": 5}' http://localhost:8080/api/maintenance/required-engineers
```

Or, since that the API is deployed on heroku (using docker), you can use:

```bash
curl -H "Content-Type: application/json" -X POST -d '{"scooters": [15, 10], "C": 9, "P": 5}' http://coup-scooters.herokuapp.com/api/maintenance/required-engineers
```

### assumptions and comments

* I sent the response with the underline in 'fleet_engineers', but a good practice its to use camelCase for rest APIs
* I implemented a greedy solution, but the problem seems to be more complex. Something related operational research.

### possible improvments

* create annotation to validate the values inside the list of the scooters by district, otherwise the application will crash
* logging
