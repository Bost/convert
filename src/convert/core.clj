(ns convert.core
  (:require
   [clojure.xml :as xml]
   [convert.allfiles :as files]
   ;[convert.fewfiles :as files]
   )
  (:gen-class :main true))

(defn x-main [fname]
  (println (str "Processing: " fname)))

(defn convert [fname]
  (let [my-data
        (try
          (xml/parse fname)
          (catch Exception e (println "ERROR: fname:" fname (.getMessage e))))
        fedn (str fname ".edn")]
    (spit fedn (with-out-str (pr my-data)))
    ;(println (str "Creating: " fedn))
    ))

(defn convert-files!
  "side effects"
  []
  (doseq [fname files/fnames]
    (convert fname))
  (println "Files converted:" (count files/fnames)))

(defn -main [& args]
  (convert-files!))
