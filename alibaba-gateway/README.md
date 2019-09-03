nacos动态规则

* dataId：gateway-router

* group：alibaba

```
[{
	"id": "gift_route",
	"order": 0,
	"predicates": [{
		"args": {
			"pattern": "/api/gift/**"
		},
		"name": "Path"
	}],
	"filters": [{
		"args": {
			"pattern": "1"
		},
		"name": "StripPrefix"
	}],
	"uri": "lb://alibaba-gift-provider"
}, {
	"id": "live_route",
	"order": 2,
	"predicates": [{
		"args": {
			"pattern": "/api/live/**"
		},
		"name": "Path"
	}],
	"filters": [{
		"args": {
			"pattern": "1"
		},
		"name": "StripPrefix"
	}],
	"uri": "lb://alibaba-live-provider"
}, {
	"id": "user_route",
	"order":3,
	"predicates": [{
		"args": {
			"pattern": "/api/user/**"
		},
		"name": "Path"
	}],
	"filters": [{
		"args": {
			"pattern": "1"
		},
		"name": "StripPrefix"
	}],
	"uri": "lb://alibaba-user-provider"
}]
```