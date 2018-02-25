# Parking API

This is the API that clients should hit (rather than the h2o model model directly).

## Requirements

Java 8

## Preparation

TODO(not required yet): Run the [h2o model service](https://github.com/bath-ml/h2o-api).

The model currently only returns dummy data.

## Running the server

Run the following in the root of the project:

```
./gradlew bootRun
```

## Stop the server
Do `ctrl+c` in the command line window where this server is running.


## Making requests

[resquest JSON](req.json)

carpark: name of the car park in Bath.
time04Day: time of the day in 24h format.
weekday: week day counting from Sunday as 1.
weekNumber: number of the week in the year.
rugby: whether a rugby match is happening in Bath that day or not.
rugbyHomeWin: whether the Bath rugby team won the match or not.
cityEvents: the number of events happening in Bath that day.
weather: weather on that day. This splits into the following four;
	rain: whether there is rain or not.
	fog: whether there is a fog or not.
	snow: whether there is snow or not.
	precipitation: precipitation in millimeters.


[response JSON](res.json)

prediction: predicted parking availability of the selected car park.
bucket: predicted probability in bins of 10%, total of 11 bins (0-10% up to 100-110%).
probabilities: probability of each bin likely to be true. 
carparkDetails: details of the selected car park.
postCode: post code of the selected car park.
capacity: total capacity of the selected car park.

