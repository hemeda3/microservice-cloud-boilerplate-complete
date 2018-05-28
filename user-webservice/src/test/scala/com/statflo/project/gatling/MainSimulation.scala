class MainSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080") // Here is the root for all relative URLs

  val scn = scenario("Sample")
    .exec(http("request1")
      .get("/"))
    .pause(100 milliseconds)
  setUp(scn.inject(rampUsers(20) over(5 seconds)) .protocols(httpConf))
}