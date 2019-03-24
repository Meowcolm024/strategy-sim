# Strategy Simulation

>Inspired by _The Selfish Genes_

## About

This is a program which simulates interactions in society, the two targets can either choose from _betray_ or _cooperate_.
The program will simulate different strategies and a set of rules to find out the best one, which gains most scores.

## Rules

1. if both choose _cooperate_, both of them will get **3** points.
2. if one of them chooses _cooperate_ and the other chooses _betray_, the one who chooses _betray_ will get **5**, but the other one gets **0**.
3. if both of them choose _betray_, both of them will lose *1* point.

## Models

* **BaseModel**: The base of any other strategy
* **KindModel**: The strategy that always cooperates
* **MaliceModel**: The opposite of the KindModel which always betrays
* **StandardModel**: This strategy will cooperate unless the target has betrayed last time
* **ReverseModel**: The opposite of the StandardModel, which will betray the one which has cooperated last time
* **OnceModel**: Like the StandardModel, but it will not cooperate with those that have betrayed once 
* **RandModel**: Randomly select cooperate or betray
* **OnRdModel**: Same as the OnceModel, but would choose to betray every 10th time

