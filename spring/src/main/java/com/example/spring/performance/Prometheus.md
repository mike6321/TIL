### prometheus setting

```yaml
global:
  scrape_interval: 15s # Set the scrape interval to every 15 seconds. Default is every 1 minute.
  evaluation_interval: 15s # Evaluate rules every 15 seconds. The default is every 1 minute.
  # scrape_timeout is set to the global default (10s).

# Alertmanager configuration
alerting:
  alertmanagers:
    - static_configs:
        - targets:
          # - alertmanager:9093

# Load rules once and periodically evaluate them according to the global 'evaluation_interval'.
rule_files:
  # - "first_rules.yml"
  # - "second_rules.yml"

# A scrape configuration containing exactly one endpoint to scrape:
# Here it's Prometheus itself.
scrape_configs:
  # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
  - job_name: "prometheus"

    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.

    static_configs:
      - targets: ["localhost:9090"]

  - job_name: "spring-actuator"
    metrics_path: '/actuator/prometheus'
    scrape_interval: 1s
    static_configs:
      - targets: ["localhost:8080"]
```

<img width="1427" alt="image" src="https://github.com/mike6321/TIL/assets/33277588/ec8d65d3-ef5d-4b9c-92bb-5f9e90a4c58d">

------

### prometheus options

* http_server_requests_seconds_count

filter

* http_server_requests_seconds_count{uri="/log"}
* http_server_requests_seconds_count {uri!="/actuator/prometheus"}
* http_server_requests_seconds_count {method=~"GET|POST"}

operator

* sum(http_server_requests_seconds_count)
* sum by (method, state) (http_server_requests_seconds_count)
* topk(3, http_server_requests_seconds_count)
* http_server_requests_seconds_count offset 1m

vector

* http_server_requests_seconds_count[1m]

------

Gauge

* system_cpu_usage

Counter

* http_server_requests_seconds_count{uri="/log"}
* 특정구간이 되면 그래프로 특정 시간에 얼마나 많은 고객의 요청이 들어왔는지 한눈에 파악하기 힘들다.

<img width="1775" alt="image" src="https://github.com/mike6321/TIL/assets/33277588/bbacac9e-06cb-4b1f-8ec7-37ce3ef59be9">

* increase(http_server_requests_seconds_count {uri="/log"} [1m])
* 누적된 값을 보여주는게 아닌 특정 시간에 얼마나 많은 유입이 들어왔는지 확인가능

<img width="1762" alt="image" src="https://github.com/mike6321/TIL/assets/33277588/1aa622b0-1b54-47b9-abf5-94eafd90340f">

* irate(http_server_requests_seconds_count {uri="/log"} [1m])
* 급격하게 증가하는 구간 확인

<img width="1777" alt="image" src="https://github.com/mike6321/TIL/assets/33277588/fbda9011-3cd8-4ce8-ab77-7906118312a1">