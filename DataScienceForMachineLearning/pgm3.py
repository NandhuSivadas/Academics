# M24CA1L306 Data Science Lab
# Lab Exercise #03: Titanic Dataset EDA
# Name: [Your Name]
# Reg No: [Your Reg No]
# Date of Submission: 12 Sept 2025

# Import necessary libraries
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import plotly.express as px
from pandas.plotting import andrews_curves

# --- Setup and Data Loading ---

# Load the dataset
# Make sure 'Titanic_Train.csv' is uploaded to your Colab environment
try:
    df = pd.read_csv('titanic.csv')
except FileNotFoundError:
    print("Error: 'Titanic_Train.csv' not found. Please upload the file to your Colab environment.")
    # Create a dummy dataframe to avoid further errors in a non-interactive environment
    df = pd.DataFrame()

if not df.empty:
    print("Dataset loaded successfully.")
    print("First 5 rows of the dataset:")
    print(df.head())
    print("\nDataset Info:")
    df.info()

    # --- Data Preprocessing for Visualization ---
    # Fill missing 'Age' values with the median age for better visualization
    df['Age'].fillna(df['Age'].median(), inplace=True)

    # Fill missing 'Embarked' values with the mode
    df['Embarked'].fillna(df['Embarked'].mode()[0], inplace=True)

    # Drop the 'Cabin' column as it has too many missing values for this analysis
    # A more advanced analysis might try to extract features from it (e.g., deck)
    df.drop('Cabin', axis=1, inplace=True)


    # --- Exploratory Data Analysis (EDA) ---

    # Set plot style for better aesthetics
    sns.set_style("whitegrid")
    plt.rcParams['figure.figsize'] = (10, 6)

    # --- 1. What percentage of passengers survived? ---
    print("\n--- Question 1: Survival Percentage ---")
    survival_percentage = df['Survived'].value_counts(normalize=True) * 100
    print(f"Survival Percentage:\n{survival_percentage}\n")

    plt.figure(figsize=(8, 5))
    ax = sns.countplot(x='Survived', data=df, palette='viridis')
    plt.title('Survival Count of Titanic Passengers', fontsize=16)
    plt.xlabel('Survival Status (0 = No, 1 = Yes)', fontsize=12)
    plt.ylabel('Number of Passengers', fontsize=12)
    plt.xticks([0, 1], ['Did not Survive', 'Survived'])
    # Add annotations
    for p in ax.patches:
        ax.annotate(f'{p.get_height()}', (p.get_x() + p.get_width() / 2., p.get_height()),
                    ha = 'center', va = 'center', xytext = (0, 9), textcoords = 'offset points')
    plt.show()
    print("""
    Findings #1:
    The bar chart clearly shows the number of passengers who survived versus those who did not.
    Out of 891 passengers in this dataset, only 342 survived, while 549 did not.
    This confirms the insight that the survival rate was low, specifically around 38.4%.
    """)


    # --- 2. Did gender influence survival chances? ---
    print("\n--- Question 2: Gender and Survival ---")
    plt.figure(figsize=(8, 5))
    sns.countplot(x='Sex', hue='Survived', data=df, palette='plasma')
    plt.title('Survival Count by Gender', fontsize=16)
    plt.xlabel('Gender', fontsize=12)
    plt.ylabel('Number of Passengers', fontsize=12)
    plt.legend(title='Survival Status', labels=['Did not Survive', 'Survived'])
    plt.show()
    print("""
    Findings #2:
    This grouped bar chart compares survival counts for males and females.
    It is immediately apparent that a much higher proportion of females survived compared to males.
    The majority of male passengers did not survive, whereas the majority of female passengers did.
    This strongly suggests that gender was a critical factor in determining survival, aligning with the "women and children first" protocol.
    """)


    # --- 3. How did passenger class (Pclass) affect survival? ---
    print("\n--- Question 3: Passenger Class and Survival ---")
    class_survival = df.groupby(['Pclass', 'Survived']).size().unstack()
    class_survival.plot(kind='bar', stacked=True, color=['#440154', '#21908d'])
    plt.title('Survival Count by Passenger Class (Stacked)', fontsize=16)
    plt.xlabel('Passenger Class', fontsize=12)
    plt.ylabel('Number of Passengers', fontsize=12)
    plt.xticks(rotation=0)
    plt.legend(title='Survival Status', labels=['Did not Survive', 'Survived'])
    plt.show()
    print("""
    Findings #3:
    The stacked bar chart visualizes survival within each passenger class.
    - 1st Class: A majority of passengers survived.
    - 2nd Class: The number of survivors and non-survivors is roughly equal.
    - 3rd Class: A vast majority of passengers did not survive.
    This demonstrates a clear correlation between higher passenger class and a higher chance of survival.
    """)


    # --- 4. Was age a factor in survival? ---
    print("\n--- Question 4: Age and Survival ---")
    plt.figure(figsize=(12, 6))
    sns.histplot(data=df, x='Age', hue='Survived', multiple='stack', kde=True, bins=30, palette='magma')
    plt.title('Age Distribution by Survival Status', fontsize=16)
    plt.xlabel('Age', fontsize=12)
    plt.ylabel('Number of Passengers', fontsize=12)
    plt.legend(title='Survival Status', labels=['Survived', 'Did not Survive'])
    plt.show()
    print("""
    Findings #4:
    This histogram with a Kernel Density Estimate (KDE) overlay shows the age distribution for survivors and non-survivors.
    The highest peak for non-survivors is in the young adult range (approx. 20-35 years old).
    A noticeable peak for survivors is seen in the children's age range (approx. 0-10 years old), indicating that a higher proportion of children were saved.
    Age was indeed a significant factor in survival.
    """)


    # --- 5. Which age group had the highest survival rate? ---
    print("\n--- Question 5: Age Group Survival Rate ---")
    age_bins = [0, 12, 18, 35, 60, 80]
    age_labels = ['Child', 'Teenager', 'Youth', 'Adult', 'Elderly']
    df['AgeGroup'] = pd.cut(df['Age'], bins=age_bins, labels=age_labels, right=False)

    age_group_survival = df.groupby('AgeGroup')['Survived'].mean().reset_index()

    plt.figure(figsize=(10, 6))
    sns.barplot(x='AgeGroup', y='Survived', data=age_group_survival, palette='coolwarm')
    plt.title('Survival Rate by Age Group', fontsize=16)
    plt.xlabel('Age Group', fontsize=12)
    plt.ylabel('Survival Rate', fontsize=12)
    plt.ylim(0, 1)
    plt.show()
    print("""
    Findings #5:
    After binning passengers into distinct age groups, we can clearly see the survival rate for each.
    The 'Child' group (0-12 years) had the highest survival rate, at nearly 60%.
    The survival rate drops for other age groups, with the 'Youth' and 'Adult' categories having rates below 40%.
    This confirms the insight that children had the best chance of survival.
    """)


    # --- 6. Did family size affect survival chances? ---
    print("\n--- Question 6: Family Size and Survival ---")
    df['FamilySize'] = df['SibSp'] + df['Parch'] + 1
    family_survival = df.groupby('FamilySize')['Survived'].mean().reset_index()

    plt.figure(figsize=(12, 6))
    sns.barplot(x='FamilySize', y='Survived', data=family_survival, palette='viridis')
    plt.title('Survival Rate by Family Size', fontsize=16)
    plt.xlabel('Family Size (SibSp + Parch + 1)', fontsize=12)
    plt.ylabel('Survival Rate', fontsize=12)
    plt.ylim(0, 1)
    plt.show()
    print("""
    Findings #6:
    By creating a 'FamilySize' feature, we can analyze its impact on survival.
    - Passengers who were alone (FamilySize = 1) had a low survival rate (around 30%).
    - Small families of 2 to 4 members had the highest survival rates (over 50%).
    - Large families (5 or more members) had very poor survival rates, possibly due to the difficulty of keeping everyone together during the chaos.
    This suggests that being in a small family provided a survival advantage over being alone or in a very large family.
    """)


    # --- 7. Did the embarkation port influence survival? ---
    print("\n--- Question 7: Embarkation Port and Survival ---")
    plt.figure(figsize=(10, 6))
    sns.countplot(x='Embarked', hue='Survived', data=df, palette='Set2')
    plt.title('Survival Count by Port of Embarkation', fontsize=16)
    plt.xlabel('Port of Embarkation (C=Cherbourg, Q=Queenstown, S=Southampton)', fontsize=12)
    plt.ylabel('Number of Passengers', fontsize=12)
    plt.legend(title='Survival Status', labels=['Did not Survive', 'Survived'])
    plt.show()
    print("""
    Findings #7:
    This chart compares survival counts based on the port of embarkation.
    Passengers who embarked at Cherbourg (C) had a noticeably higher survival rate compared to those from Queenstown (Q) and Southampton (S).
    The majority of passengers embarked at Southampton (S), and the majority of them did not survive. This might be correlated with passenger class, as many 3rd class passengers boarded at Southampton.
    """)


    # --- 8. Did fare have any relationship with survival? ---
    print("\n--- Question 8: Fare and Survival (Quartile/Box Plot) ---")
    plt.figure(figsize=(12, 7))
    # Using a log scale for the y-axis to better visualize the distribution for a wide range of fares
    sns.boxplot(x='Survived', y='Fare', data=df, palette='winter')
    plt.title('Fare Distribution by Survival Status', fontsize=16)
    plt.xlabel('Survival Status (0 = No, 1 = Yes)', fontsize=12)
    plt.ylabel('Fare', fontsize=12)
    plt.xticks([0, 1], ['Did not Survive', 'Survived'])
    # plt.yscale('log') # Uncomment for log scale if fares are heavily skewed
    plt.show()
    print("""
    Findings #8:
    The box plot (or quartile plot) shows the distribution of fares paid by survivors and non-survivors.
    The median fare for passengers who survived is significantly higher than for those who did not.
    The entire distribution for survivors is shifted upwards, indicating that passengers who paid higher fares had a better chance of survival.
    This is strongly linked to passenger class, as 1st class tickets were the most expensive.
    """)


    # --- 9. Which combination of factors best explains survival? ---
    print("\n--- Question 9: Combination of Factors (Gender + Class) ---")
    g = sns.FacetGrid(df, col='Pclass', row='Sex', hue='Survived', margin_titles=True, palette='seismic')
    g.map(plt.hist, 'Age', bins=20, alpha=0.7)
    g.add_legend(title='Survival Status', labels=['Did not Survive', 'Survived'])
    g.fig.suptitle('Survival by Age, Gender, and Class', y=1.03, fontsize=16)
    plt.show()
    print("""
    Findings #9:
    This FacetGrid provides a powerful multi-dimensional view, breaking down survival by class, gender, and age.
    - Females: Survival was very high for females in 1st and 2nd class, regardless of age. Survival for 3rd class females was around 50%.
    - Males: Survival was low across all classes. The best chances for males were among young boys in 1st and 2nd class. Adult males in 3rd class had the lowest survival rate of any group.
    This confirms the insight that young females in upper classes had the highest probability of survival.
    """)


    # --- 10. Were there passengers with missing data? ---
    print("\n--- Question 10: Missing Data Analysis ---")
    # We re-load the original data to show the true missing values before we handled them
    original_df = pd.read_csv('Titanic_Train.csv')
    missing_data = original_df.isnull().sum().sort_values(ascending=False)
    print("Count of missing values per column:")
    print(missing_data[missing_data > 0])

    plt.figure(figsize=(10, 6))
    sns.heatmap(original_df.isnull(), cbar=False, cmap='viridis', yticklabels=False)
    plt.title('Heatmap of Missing Data in the Titanic Dataset', fontsize=16)
    plt.show()
    print("""
    Findings #10:
    The heatmap and the printed summary show which columns have missing data.
    - 'Cabin': Has a very large number of missing values (687 out of 891). This makes it difficult to use directly without significant feature engineering.
    - 'Age': Has a substantial number of missing values (177). This is a critical feature, and we handled it by filling in the median age. Ignoring these rows would discard too much data, while leaving them could break many algorithms.
    - 'Embarked': Has only two missing values, which can be easily filled with the most common port.
    Not handling these missing values can lead to biased or incorrect conclusions and errors during model training.
    """)


    # --- Additional Requested Visualizations ---
    print("\n--- Additional Requested Visualizations ---")

    # 1. Scatter Multiple (Age vs Fare, colored by Survival)
    plt.figure(figsize=(12, 7))
    sns.scatterplot(data=df, x='Age', y='Fare', hue='Survived', style='Pclass', palette='bwr', alpha=0.8)
    plt.title('Scatterplot of Age vs. Fare by Survival and Class', fontsize=16)
    plt.show()
    print("Findings (Scatter Multiple): Shows that most non-survivors are clustered in the low-fare, young-adult area. Survivors are more spread out, especially towards higher fares.")

    # 2. Scatter Matrix (Pairplot)
    sns.pairplot(df[['Survived', 'Pclass', 'Age', 'Fare', 'FamilySize']], hue='Survived', palette='viridis')
    plt.suptitle('Scatter Matrix (Pairplot) of Key Features', y=1.02, fontsize=16)
    plt.show()
    print("Findings (Scatter Matrix): Provides a matrix of relationships. The histograms on the diagonal re-confirm previous findings (e.g., more non-survivors). The scatterplots show correlations, such as Fare being inversely related to Pclass.")

    # 3. Bubble Chart (Age vs Fare, size by FamilySize)
    fig = px.scatter(df, x="Age", y="Fare",
                 size="FamilySize", color="Survived",
                 hover_name="Name", log_y=True, size_max=60,
                 title="Bubble Chart: Age vs Fare (Size by Family Size, Color by Survival)")
    fig.show()
    print("Findings (Bubble Chart): An interactive plot where bubble size represents family size. It highlights that many of the largest families (largest bubbles) with low fares did not survive.")

    # 4. Density Chart (2D KDE Plot)
    plt.figure(figsize=(12, 7))
    sns.kdeplot(data=df, x='Age', y='Fare', hue='Survived', fill=True, palette='coolwarm')
    plt.title('2D Density Chart of Age and Fare by Survival', fontsize=16)
    plt.ylim(0, 300) # Limit fare to see density concentrations better
    plt.show()
    print("Findings (Density Chart): The red area (not survived) shows a high concentration of passengers around 20-30 years old who paid very low fares. The blue area (survived) is more spread out, with a notable concentration at higher fare levels.")

    # 5. Parallel Coordinates Chart
    parallel_df = df[['Pclass', 'Sex', 'Age', 'Fare', 'Embarked', 'Survived']]
    parallel_df['Sex'] = parallel_df['Sex'].astype('category').cat.codes
    parallel_df['Embarked'] = parallel_df['Embarked'].astype('category').cat.codes

    fig = px.parallel_coordinates(parallel_df, color="Survived",
                                  color_continuous_scale=px.colors.sequential.Viridis,
                                  title="Parallel Coordinates Plot for Survival Factors")
    fig.show()
    print("Findings (Parallel Coordinates): This chart maps each passenger as a line. A large bundle of blue lines (survived) can be seen passing through Sex=0 (female) and Pclass=1. A large bundle of yellow lines (not survived) passes through Sex=1 (male) and Pclass=3.")

    # 6. Deviation Chart (Survival Rate vs. Average)
    avg_survival_rate = df['Survived'].mean()
    class_survival_rate = df.groupby('Pclass')['Survived'].mean()
    class_survival_rate['Average'] = avg_survival_rate
    deviation = (class_survival_rate - avg_survival_rate).sort_values(ascending=False)

    deviation.plot(kind='barh', color=(deviation > 0).map({True: 'g', False: 'r'}))
    plt.title('Deviation of Survival Rate by Class from Average', fontsize=16)
    plt.xlabel('Deviation from Average Survival Rate')
    plt.axvline(0, color='k', linestyle='--')
    plt.show()
    print("Findings (Deviation Chart): Clearly shows that 1st class passengers had a survival rate well above the average, while 3rd class passengers were significantly below average.")

    # 7. Andrews Curves
    plt.figure(figsize=(12, 8))
    andrews_curves(parallel_df, 'Survived', colormap='viridis')
    plt.title('Andrews Curves of Titanic Features by Survival', fontsize=16)
    plt.show()
    print("Findings (Andrews Curves): Andrews curves represent each data point as a curve. Different classes (colors) show different patterns. The green curves (survived) tend to have a different shape and grouping from the purple curves (not survived), indicating that the underlying feature values can be used to separate the two outcomes.")
