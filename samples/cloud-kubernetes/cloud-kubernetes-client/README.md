oc create rolebinding matg09-admin-binding --clusterrole=admin --user=system:serviceaccount:utilidades-matg09:default --namespace=utilidades-matg09

oc create rolebinding matg09-admin-binding --clusterrole=admin --user=ssystem:serviceaccount:curso:default --namespace=curso

oc delete all -l app=cloud-kubernetes-client

oc scale --replicas=2 deploymentconfig cloud-kubernetes-service