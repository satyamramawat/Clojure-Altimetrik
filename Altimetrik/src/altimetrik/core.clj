;;Author - Satyam Ramawat
(ns altimetrik.core)

(defn sqrt-range [n]
  "Function to generate the list upto square root of N"
  (take-while #(>= n (* % %)) (range 2 1.0E15) ))

(defn is-prime? [n]
  "Function to check whether a number is a prime number or not"
  (if (< n 2)
    false
    (let [s (sqrt-range n)]
      (every? true? (map #(not= 0 (rem n %)) s)))))

(defn prime-multiplication-table [n]
  "This Functon prints Multiplication table of n Prime Number"
  (let [first_ten_prime(take n(filter is-prime? (range)))]
    (loop [x 0]                                                                                                    
      (when ( < x n)
        (let [nth_prime_element (nth first_ten_prime x)]
          (println "Prime Number Table:" nth_prime_element)
          (loop [z 0]                                                      ;;This loop prints Multiplication Table
            (when (<= z 10)
              (println nth_prime_element "x" z (* nth_prime_element z))
              (recur(inc z))))
          (recur(inc x)))))))

(defn -main [& args]
  "Funtion which takes user input"
  (println "Please provide the value to print prime number table whereas,\nIf 0 provided as input than it will print first 10 prime numbers table\nNOTE: If string is provided instead of number than program will be terminated")
  (try  
    (def main_number (Integer/parseInt (read-line)))
    (if (= main_number 0)
      (do
        (prime-multiplication-table 10))
      (do 
        (prime-multiplication-table main_number)))
    (catch Exception e nil))
  (time (Thread/sleep 1000)))
