# npm-deps demo

Demonstrates the new npm-deps feature of clojurescript compiler

## Dev

```
lein figwheel dev
```

or

```
m+x cider-jack-in

(start!)
```

http://localhost:8080

## Prod

```
lein cljsbuild once min

node server.js
```

http://localhost:8080