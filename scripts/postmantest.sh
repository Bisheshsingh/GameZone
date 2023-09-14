sleep 60
echo PostMan Tests Started
postman collection run "28989418-3a3c5990-6a0a-41d6-a601-6cfad04ac644" --integration-id "148257-${{ github.run_id }}"
postman api lint 440cb951-f437-470a-8085-3e0e90a57263 --integration-id 148257
echo Tests Completed

if [ $? -eq 0 ]; then
    echo Tests Passed
    exit 0
else
    echo Tests Failed
    exit 1
fi