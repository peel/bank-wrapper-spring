#!/bin/bash

curl -i -X POST -H "Content-Type:application/json" -d '{  "account" : "123456",  "phone" : "0048123456789", "address": "Lorem Ipsum 19342", "name": "John Doe" }' http://localhost:8001/customers
