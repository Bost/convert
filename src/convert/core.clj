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
  ;; TODO catch org.xml.sax.SAXParseException
  (let [my-data (xml/parse fname)
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
