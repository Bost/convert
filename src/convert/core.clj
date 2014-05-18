(ns convert.core
  (:require
   [clojure.xml :as xml]
   [convert.allfiles :as files]
   ;; [convert.fewfiles :as files]
   )
  (:gen-class :main true))

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

(defn fix-files []
  (let [files [ "/home/bost/vircurex/2013/08/31/vircurex.2013-08-31_15-05-30.xml"
                "/home/bost/vircurex/2013/08/31/vircurex.2013-08-31_15-10-37.xml"
                "/home/bost/vircurex/2013/08/31/vircurex.2013-08-31_15-36-50.xml"
                "/home/bost/vircurex/2013/08/31/vircurex.2013-08-31_15-20-53.xml"
                ]]
        (doseq [fname files]
          (convert fname))
        (println "Files fixed: " (count files))))

(defn -main [& args]
  (convert-files!))
