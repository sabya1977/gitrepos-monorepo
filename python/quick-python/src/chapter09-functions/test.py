def requires_login(func):
    def wrapper(user):
        if not user.get("logged_in"):
            print("Access denied")
            return
        return func(user)
    return wrapper
@requires_login
def view_profile(user):
    print("Showing profile")

user = {"logged_in": False}
view_profile(user)