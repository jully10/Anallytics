#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class EDA(database, columns = None, identifers = None):
    def describe 
    
    
    


# In[42]:


import numpy as np
import pandas as pd
import reportlab
from sklearn import datasets
import seaborn as sns


# In[17]:


import matplotlib.pyplot as plt
from reportlab.lib import colors
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.enums import TA_CENTER
from reportlab.platypus.tables import Table, TableStyle
from io import BytesIO


# In[25]:


class report_pdf:
    
    def __init__(self, name = 'report.pdf', title = 'Report', pages = None):
    
        self.name = name
        # Create a PDF report
        if pages == None:
            self.doc = SimpleDocTemplate(name, pagesize=letter)

        else:
            self.doc = SimpleDocTemplate(name, pagesize=pages)
        self.story = []

        # Add a title to the report
        styles = getSampleStyleSheet()
        title = Paragraph(title, styles['Title'])
        self.story.append(title)
        self.story.append(Spacer(1, 12))

    def add_image(self):
        # Save the Matplotlib plot as an image
        plot_image = BytesIO()
        plt.savefig(plot_image, format='png')


        # Add the data visualization (Matplotlib plot) to the report
        plot_image.seek(0)
        plot_img = Image(plot_image)
        plot_img.drawHeight = 300
        plot_img.drawWidth = 500
        #add image to report
        self.story.append(plot_img)
        self.story.append(Spacer(1, 12))
        
    def add_table(self,data):
        
        #convert Dataframe to arrays
        table = Table([data.columns.tolist()] + data.values.tolist())
        
        #set style
        table.setStyle(TableStyle([
            ('BACKGROUND', (0, 0), (-1, 0), colors.grey),
            ('TEXTCOLOR', (0, 0), (-1, 0), colors.whitesmoke),
            ('ALIGN', (0, 0), (-1, -1), 'CENTER'),
            ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
            ('BOTTOMPADDING', (0, 0), (-1, 0), 12),
            ('BACKGROUND', (0, 1), (-1, -1), colors.beige),
            ('GRID', (0, 0), (-1, -1), 1, colors.black)
        ]))
        
         #add table to report
        self.story.append(table)
    
    def build_report(self):
        # Build the PDF report
        self.doc.build(self.story)
        self.story.append(Spacer(1, 12))

        print(f"PDF report saved as {self.name}")


# In[26]:


class data_vis:
    def __init__(self, base, save = False, report_doc = None):
        
        self.base = base.copy()
        self.save = save
        self.report_doc = report_doc
            
    def vis_base(self, base = None, title = 'base de dados', save = False):
        
        self.save = save
        if base == None:
            base = self.base
        if self.save:
            base.to_excel(title+'.xlsx')
        
        if self.report_doc:
            self.report_doc.add_table(base)
    
    
    def graph_bar(self, category ,numeric, title = 'Bar Chart', save = False ):
        
        self.save = save
        
        plt.figure(figsize=(8, 4))
        plt.bar(self.base[category], self.base[numeric])
        plt.xlabel(category)
        plt.ylabel(numeric)
        plt.title(title)
        
        if self.save:
            plt.savefig(title, format='png')
        
        if self.report_doc:
            self.report_doc.add_image()
            
        plt.close()
        
#    # Example visualizations
#plt.figure(figsize=(10, 6))
#sns.histplot(df['NumericColumn'], kde=True)
#plt.title('Histogram of Numeric Column')
#
#plt.figure(figsize=(10, 6))
#sns.boxplot(x='CategoricalColumn', y='NumericColumn', data=df)
#plt.title('Box Plot of Numeric Column by Category')
#
#plt.figure(figsize=(10, 6))
#sns.scatterplot(x='Feature1', y='Feature2', data=df)
#plt.title('Scatter Plot of Two Features')
#
#plt.figure(figsize=(10, 6))
#correlation_matrix = df.corr()
#sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm')
#plt.title('Correlation Matrix')
#
#cross_tab = pd.crosstab(df['CategoricalColumn1'], df['CategoricalColumn2'])
#plt.figure(figsize=(10, 6))
#sns.heatmap(cross_tab, annot=True, cmap='YlGnBu')
#plt.title('Crosstab Heatmap')
#
## Data Visualization
## Example visualizations for categorical columns
#plt.figure(figsize=(10, 6))
#sns.countplot(x='CategoricalColumn', data=df)
#plt.title('Count of Each Category in Categorical Column')
#
#plt.figure(figsize=(12, 6))
#sns.boxplot(x='CategoricalColumn', y='NumericColumn', data=df)
#plt.title('Box Plot of Numeric Column by Category')
#
#plt.figure(figsize=(10, 6))
#sns.barplot(x='CategoricalColumn', y='NumericColumn', data=df, ci=None)
#plt.title('Bar Plot of Numeric Column by Category')
#


# In[27]:


df_ = datasets.load_iris()
data = pd.DataFrame(df_['data'], columns = df_.feature_names)
data['classe'] = df_.target
data


# In[28]:


report = report_pdf()
data_vis = data_vis(data, save = True, report_doc = report)


# In[29]:


data_vis.vis_base(save = True)
data_vis.graph_bar('classe','sepal length (cm)', save = True)
report.build_report()


# In[30]:


df_des = data.describe()
df_des 


# In[31]:


df_des.loc['z_score+'] = df_des.loc['mean'] + df_des.loc['std']


# In[32]:


df_des.loc['z_score-'] = df_des.loc['mean'] - df_des.loc['std']


# In[33]:


df_des.loc['amplitude'] = df_des.loc['max'] - df_des.loc['min']


# In[34]:


df_des.loc['IQR'] = df_des.loc['75%'] - df_des.loc['25%']


# In[35]:


df_des.loc['IQR'] * 1.5


# In[36]:


df_des.loc['Limit_superior'] = df_des.loc['75%'] + (df_des.loc['IQR'] * 1.5) 
df_des.loc['Limit_inferior'] = df_des.loc['25%'] - (df_des.loc['IQR'] * 1.5) 


# In[37]:


df_des


# In[44]:


data = {
    'Name': ['Alice', 'Bob', 'Charlie', 'David', 'Alice'],
    'Age': [25, 30, 22, 28, 20],
    'City': ['New York', 'San Francisco', 'Los Angeles', 'Chicago', 'Chicago']
}
df = pd.DataFrame(data)


# In[45]:


df


# In[54]:


aux = pd.DataFrame()
df_final = pd.DataFrame()
aux = df['Name'].value_counts().reset_index()
aux['coluna'] = 'Name'
aux.columns = ['categoria','quantidade', 'coluna']
df_final = pd.concat([df_final,aux])


# In[56]:


df_final = pd.concat([df_final,aux])
df_final[['coluna','categoria','quantidade']]


# In[59]:


df_final = pd.DataFrame()
for col in df[['Name', 'City']].columns:
    aux = df[col].value_counts().reset_index()
    aux['coluna'] = col
    aux.columns = ['categoria','quantidade', 'coluna']
    aux['%'] = aux['quantidade']/len(df)
    df_final = pd.concat([df_final,aux])
df_final[['coluna','categoria','quantidade','%']]


# In[46]:


plt.figure(figsize=(10, 6))
sns.countplot(x='Name', data=df)
plt.title('Count of Each Category in Categorical Column')


# In[ ]:




