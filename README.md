## Dependencies
- ollama: install ollama and pull phi3 with 'ollama pull phi3'
- litellm: install litellm and run it with 'litellm --model ollama/phi3:latest'

After that you can just run the main class in the IDE.
My observed behavior is that the proper kernel function is executed, but it is executed
5 times before the chat completion call returns. The mystery is why it isn't just
executed once :)