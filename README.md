# Investment
Web Crawler for Investment

## Service Account
To authenticate a service account and authorize it to access Firebase services, need to generate a private key file in JSON format.

To generate a private key file for the service account:

1. In the Firebase console, open `Settings > Service Accounts`.
2. Click `Generate New Private Key`, then confirm by clicking `Generate Key`.
3. Securely store the JSON file containing the key in `firebase/serviceAccountKey.json`.

Reference: https://firebase.google.com/docs/firestore/quickstart#initialize