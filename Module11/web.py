from flask import Flask

app = Flask(__name__)

@app.route('/')
def pointpark():
    return 'Point Park is almost out for the semester'

if __name__ == '__main__':
    app.run(debug=True)
