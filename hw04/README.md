# ДЗ 04

Все решения лежат в отдельных файлах с номером задания.  
Ниже представлены результаты работы консольных приложений.

## 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

Результат работы программы:  
```
Original list is: [null, 1, 2, true, 4, five, false]
Reversed list is: [false, five, 4, true, 2, 1, null]
```

## 2. Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.

Результат работы программы:  
```
Try enqueue: 0
Try enqueue: 1
Try enqueue: 2
Try enqueue: 3
Try enqueue: 4
Queue is: [4, 3, 2, 1, 0]
Try dequeue: 0
Try dequeue: 1
Try dequeue: 2
Queue is: [4, 3]
Try first: 3
Queue is: [4, 3]
```

## 3. *В калькулятор добавьте возможность отменить последнюю операцию.
За основу взял программу калькулятора из ДЗ 02.  
Результат работы программы:  

```
Введите число: 5
Введите операцию (+, -, *, /), 'revert' или 'exit': +
Введите число: 2
Результат = 7.0
Введите операцию (+, -, *, /), 'revert' или 'exit': *
Введите число: 6
Результат = 42.0
Введите операцию (+, -, *, /), 'revert' или 'exit': revert
Результат = 7.0
Введите операцию (+, -, *, /), 'revert' или 'exit': revert
Результат = 5.0
Введите операцию (+, -, *, /), 'revert' или 'exit': exit
```